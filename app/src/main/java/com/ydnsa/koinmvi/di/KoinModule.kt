package com.ydnsa.koinmvi.di

import androidx.lifecycle.*
import com.ydnsa.koinmvi.data.fake.*
import com.ydnsa.koinmvi.data.local.*
import com.ydnsa.koinmvi.data.network.repository.*
import com.ydnsa.koinmvi.domain.usecase.*
import com.ydnsa.koinmvi.presentation.home.*
import com.ydnsa.koinmvi.presentation.login.*
import com.ydnsa.koinmvi.presentation.notebook.NoteList.*
import com.ydnsa.koinmvi.presentation.notebook.notedetail.*
import org.koin.android.ext.koin.*
import org.koin.androidx.viewmodel.dsl.*
import org.koin.dsl.*

val appModule = module {
    single { LoginApi() }

    single<LoginRepository> { LoginRepositoryImpl(get()) }
    single { DataStoreManager(androidContext()) }
    factory { LoginUseCase(get()) }
    factory { FakeJsonReader() }
    viewModel {
        LoginModelView(get<LoginUseCase>() , get<DataStoreManager>())
    }
    viewModel { HomeViewModel(get<SavedStateHandle>()) }
    viewModel { NoteItemListViewModel(get<SavedStateHandle>() , get<FileDao>()) }
    viewModel { (handle : SavedStateHandle) ->
        NoteDetailViewModel(handle , get<FileDao>())
    }

}