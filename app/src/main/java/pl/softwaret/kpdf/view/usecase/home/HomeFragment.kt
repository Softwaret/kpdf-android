package pl.softwaret.kpdf.view.usecase.home

import androidx.fragment.app.viewModels
import kotlinx.android.synthetic.main.home_fragment.*
import pl.softwaret.core.model.repository.entity.publication.Publication
import pl.softwaret.kpdf.R
import pl.softwaret.kpdf.view.base.BaseFragment
import pl.softwaret.kpdf.view.usecase.home.adapter.PublicationsAdapter
import pl.softwaret.kpdf.viewmodel.usecase.home.HomeIntent
import pl.softwaret.kpdf.viewmodel.usecase.home.HomeState
import pl.softwaret.kpdf.viewmodel.usecase.home.HomeViewModel
import pl.softwaret.kpdf.viewmodel.usecase.home.HomeViewModelImpl

class HomeFragment : BaseFragment<HomeIntent, HomeState, HomeViewModel>() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    override val viewModel: HomeViewModel by viewModels<HomeViewModelImpl>()

    override fun obtainLayoutId() = R.layout.home_fragment

    override suspend fun handleState(state: HomeState) = when (state) {
        HomeState.Initial -> offerToViewModel(HomeIntent.ViewReady)
        is HomeState.PublicationsList -> showPublications(state.publications)
    }

    override fun onViewReady() {
        super.onViewReady()
        publicationsAdapter.adapter = PublicationsAdapter(emptyList())
    }

    private fun showPublications(publications: List<Publication>) {
        (publicationsAdapter.adapter as? PublicationsAdapter)?.setNewData(publications)
    }
}