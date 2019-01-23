package com.example.casekry.viewModels

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.casekry.data.entities.DataEntity
import com.example.casekry.repositories.BaseRepository
import java.lang.reflect.InvocationTargetException

abstract class BaseViewModel<ENTITY : DataEntity>(application: Application, val repository: BaseRepository<ENTITY>) :
    AndroidViewModel(application) {

    companion object {
        fun <VIEW_MODEL : BaseViewModel<ENTITY>, ENTITY : DataEntity> provideViewModel(
            fragment: Fragment,
            factory: Factory<ENTITY>,
            viewModelClass: Class<VIEW_MODEL>
        ): VIEW_MODEL {
            return ViewModelProviders.of(fragment, factory).get(viewModelClass)
        }
    }

    class Factory<ENTITY : DataEntity> constructor(
        private val application: Application,
        private val baseRepository: BaseRepository<ENTITY>
    ) : ViewModelProvider.NewInstanceFactory() {

        companion object {
            fun <ENTITY : DataEntity> get(
                fragment: Fragment,
                repository: BaseRepository<ENTITY>
            ): Factory<ENTITY> = Factory(checkApplication(checkActivity(fragment)), repository)

            private fun checkApplication(activity: Activity): Application {
                return activity.application
                    ?: throw IllegalStateException(
                        "Your activity/fragment is not yet attached to " +
                                "Application. You can't request ViewModel before onCreate call."
                    )
            }

            private fun checkActivity(fragment: Fragment): Activity {
                return fragment.activity
                    ?: throw IllegalStateException("Can't create ViewModelProvider for detached fragment")
            }
        }

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            try {
                return modelClass.getConstructor(
                    Application::class.java,
                    BaseRepository::class.java
                ).newInstance(application, baseRepository)
            } catch (e: NoSuchMethodException) {
                throw RuntimeException("Cannot create an instance of $modelClass", e)
            } catch (e: IllegalAccessException) {
                throw RuntimeException("Cannot create an instance of $modelClass", e)
            } catch (e: InstantiationException) {
                throw RuntimeException("Cannot create an instance of $modelClass", e)
            } catch (e: InvocationTargetException) {
                throw RuntimeException("Cannot create an instance of $modelClass", e)
            }
        }
    }
}