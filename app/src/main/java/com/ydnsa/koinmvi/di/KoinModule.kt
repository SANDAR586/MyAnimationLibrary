package com.ydnsa.koinmvi.di


import com.ydnsa.koinmvi.data.fake.FakeJsonReader
import com.ydnsa.koinmvi.data.fake.LoginApi
import com.ydnsa.koinmvi.data.local.DataStoreManager
import com.ydnsa.koinmvi.data.network.repository.LoginRepository
import com.ydnsa.koinmvi.data.network.repository.LoginRepositoryImpl
import com.ydnsa.koinmvi.domain.usecase.LoginUseCase
import com.ydnsa.koinmvi.presentation.home.HomeViewModel
import com.ydnsa.koinmvi.presentation.login.LoginModelView
import com.ydnsa.koinmvi.presentation.notebook.NoteList.NoteItemListViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel



val appModule= module{
    single { LoginApi() }

    single<LoginRepository> { LoginRepositoryImpl(get()) }
    single { DataStoreManager(androidContext()) }
    factory { LoginUseCase(get()) }
    factory { FakeJsonReader() }
    viewModel{
        LoginModelView(get<LoginUseCase>(),get<DataStoreManager>())
    }
    viewModel { HomeViewModel(get()) }
    viewModel { NoteItemListViewModel(get()) }


}