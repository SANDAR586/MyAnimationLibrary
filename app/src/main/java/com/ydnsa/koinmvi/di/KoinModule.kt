package com.ydnsa.koinmvi.di

import androidx.lifecycle.viewmodel.compose.viewModel
import com.ydnsa.koinmvi.data.fake.LoginApi
import com.ydnsa.koinmvi.data.repository.LoginRepository
import com.ydnsa.koinmvi.data.repository.LoginRepositoryImpl
import com.ydnsa.koinmvi.domain.usecase.LoginUseCase
import com.ydnsa.koinmvi.presentation.login.LoginModelView
import org.koin.dsl.module



val appModule= module{
    single { LoginApi() }
    single<LoginRepository> { LoginRepositoryImpl(get()) }
    factory { LoginUseCase(get()) }
    viewModel { LoginModelView() }


}