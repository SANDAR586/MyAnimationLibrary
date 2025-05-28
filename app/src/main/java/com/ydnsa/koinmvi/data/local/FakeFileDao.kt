package com.ydnsa.koinmvi.data.local

class FakeFileDao : FileDao
{
    private val files = mutableListOf<FileEntity>()
    val fakeFileEntities = listOf(
        FileEntity(
            uid = "file1" ,
            folderName = "Notes" ,
            fileLocation = "/storage/emulated/0/Notes/file1.html" ,
            title = "Meeting Notes" ,
            content = "<html>Meeting notes content</html>" ,
            timestamp = 1682505600000L // 26 Apr 2023
                  ) ,
        FileEntity(
            uid = "file2" ,
            folderName = "Ideas" ,
            fileLocation = "/storage/emulated/0/Ideas/file2.html" ,
            title = "Startup Ideas" ,
            content = "<html>Startup ideas content</html>" ,
            timestamp = 1685097600000L // 26 May 2023
                  ) ,
        FileEntity(
            uid = "file3" ,
            folderName = "Journal" ,
            fileLocation = "/storage/emulated/0/Journal/file3.html" ,
            title = "Daily Journal" ,
            content = "<html>Journal entry</html>" ,
            timestamp = 1687776000000L // 26 Jun 2023
                  )
                                 )

    override fun insertFile(vararg fileEntity : FileEntity)
    {
        files.addAll(fakeFileEntities)
    }

    override fun getAllFiles() : List<FileEntity>
    {
        return fakeFileEntities
    }

    override fun findByNameFile(uid : String) : FileEntity?
    {
        return fakeFileEntities[1]
    }
}