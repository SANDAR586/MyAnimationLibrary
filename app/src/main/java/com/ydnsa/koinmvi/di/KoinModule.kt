package com.ydnsa.koinmvi.di


import com.ydnsa.koinmvi.data.fake.LoginApi
import com.ydnsa.koinmvi.data.repository.LoginRepository
import com.ydnsa.koinmvi.data.repository.LoginRepositoryImpl
import com.ydnsa.koinmvi.domain.usecase.LoginUseCase
import com.ydnsa.koinmvi.presentation.login.LoginModelView
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel



val appModule= module{
    single { LoginApi() }
    single<LoginRepository> { LoginRepositoryImpl(get()) }
    factory { LoginUseCase(get()) }
    viewModel{
        LoginModelView(get())
    }




}