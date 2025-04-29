package com.ydnsa.koinmvi.presentation.home.components

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.ImageFormat
import android.graphics.Matrix
import android.graphics.Rect
import android.graphics.YuvImage
import android.util.Log
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import org.tensorflow.lite.Interpreter
import org.tensorflow.lite.support.common.FileUtil
import java.io.ByteArrayOutputStream
import java.nio.ByteBuffer
import java.nio.ByteOrder
import androidx.core.graphics.scale

val labels = listOf(
    "person", "bicycle", "car", "dog", "cat", "bird", "horse", "sheep", "cow", "elephant",
    "bear", "zebra", "giraffe", "airplane", "bus", "train", "truck", "boat", "traffic light",
    "fire hydrant", "stop sign", "parking meter", "bench", "bird", "cat", "dog", "horse",
    "sheep", "cow", "elephant", "bear", "zebra", "giraffe", "bat", "banana", "apple", "orange",
    "broccoli", "carrot", "hot dog", "pizza", "donut", "cake", "chair", "couch", "potted plant",
    "bed", "dining table", "toilet", "tv", "laptop", "mouse", "remote", "keyboard", "cell phone",
    "microwave", "oven", "toaster", "sink", "refrigerator", "book", "clock", "vase", "scissors",
    "teddy bear", "hair drier", "toothbrush"
)


class YourImageAnalyzer(private val context : Context) : ImageAnalysis.Analyzer {

    override fun analyze(imageProxy: ImageProxy) {
        // Convert ImageProxy to Bitmap or ByteBuffer for TensorFlow
        val rotationDegrees = imageProxy.imageInfo.rotationDegrees

        val bitmap = imageProxy.toBitmap(rotationDegrees) // You’ll implement this
        val input = preprocess(bitmap)

        // Output array (depends on your model structure)
        val output = Array(1) { Array(19206) { FloatArray(90) } }
        val model = FileUtil.loadMappedFile(context, "efficientdet_lite0.tflite")
        val interpreter = Interpreter(model)
        interpreter.run(input, output)


        // Handle the output (e.g., draw boxes, show labels, etc.)
        Log.d("TFLite", "Detected class: ${output[0].contentToString()}")
        val detections = output[0] // shape: [19206][90] for EfficientDet0

// Confidence threshold for detection (e.g., only consider detections with confidence > 0.5)
        val confidenceThreshold = 0.5f

        for (detection in detections) {
            val scores = detection.sliceArray(4 until detection.size)  // Skip the first 4 values (x, y, width, height)
            val maxScore = scores.maxOrNull() ?: 0f  // Get the max confidence score
            val classIndex = scores.indexOfFirst { it == maxScore }  // Find the class index with the max score

            if (maxScore > confidenceThreshold) {
                // Ensure the class index is within the bounds of your predefined labels
                if (classIndex in labels.indices) {
                    // Get the label for the detected class
                    val label = labels[classIndex]

                    // Display or log the detected object and confidence
                    Log.d("ObjectDetector", "Detected: $label with confidence $maxScore")
                }
            }
        }


        imageProxy.close()


    }
}


fun ImageProxy.toBitmap(rotationDegrees: Int): Bitmap {
    val yBuffer = planes[0].buffer
    val uBuffer = planes[1].buffer
    val vBuffer = planes[2].buffer

    val ySize = yBuffer.remaining()
    val uSize = uBuffer.remaining()
    val vSize = vBuffer.remaining()

    val nv21 = ByteArray(ySize + uSize + vSize)
    yBuffer.get(nv21, 0, ySize)
    vBuffer.get(nv21, ySize, vSize)
    uBuffer.get(nv21, ySize + vSize, uSize)

    val yuvImage = YuvImage(nv21, ImageFormat.NV21, width, height, null)
    val out = ByteArrayOutputStream()
    yuvImage.compressToJpeg(Rect(0, 0, width, height), 90, out)
    val yuv = out.toByteArray()
    val bitmap = BitmapFactory.decodeByteArray(yuv, 0, yuv.size)

    // Rotate if necessary
    return if (rotationDegrees != 0) {
        val matrix = Matrix().apply { postRotate(rotationDegrees.toFloat()) }
        Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, matrix, true)
    } else {
        bitmap
    }
}

fun preprocess(bitmap: Bitmap): ByteBuffer {
    val inputSize = 160  // Must match model input size
    val resized = Bitmap.createScaledBitmap(bitmap, inputSize, inputSize, true)

    val input = ByteBuffer.allocateDirect(4 * inputSize * inputSize * 3)
        .order(ByteOrder.nativeOrder())

    for (y in 0 until inputSize) {
        for (x in 0 until inputSize) {
            val pixel = resized.getPixel(x, y)
            input.putFloat(Color.red(pixel) / 255f)
            input.putFloat(Color.green(pixel) / 255f)
            input.putFloat(Color.blue(pixel) / 255f)
        }
    }

    input.rewind()
    return input
}