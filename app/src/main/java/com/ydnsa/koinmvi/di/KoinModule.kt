package com.ydnsa.koinmvi.di

import androidx.lifecycle.*
import com.ydnsa.koinmvi.data.fake.*
import com.ydnsa.koinmvi.data.local.*
import com.ydnsa.koinmvi.data.network.repository.*
import com.ydnsa.koinmvi.domain.usecase.*
import com.ydnsa.koinmvi.presentation.home.*
import com.ydnsa.koinmvi.presentation.login.*
import com.ydnsa.koinmvi.presentation.notebook.noteList.*
import com.ydnsa.koinmvi.presentation.notebook.notedetail.*
import org.koin.android.ext.koin.*
import org.koin.core.module.dsl.*
import org.koin.dsl.*

val appModule = module {
    // New DSL for singletons
    singleOf(::LoginApi)
    singleOf(::FakeJsonReader)
    single<LoginRepository> { LoginRepositoryImpl(get()) }
    single { DataStoreManager(androidContext()) }

    // New DSL for use case
    factoryOf(::LoginUseCase)
    factoryOf(::LocalAccessHelper)

    // ViewModels using traditional viewModel { } syntax (still valid)
    viewModel { LoginModelView(get() , get()) }

    viewModel { (handle : SavedStateHandle) ->
        HomeViewModel(handle)
    }

    viewModel { (handle : SavedStateHandle) ->
        NoteItemListViewModel(handle , get())
    }

    viewModel { (handle : SavedStateHandle) ->
        NoteDetailViewModel(handle , get() , get<LocalAccessHelper>())
    }
}