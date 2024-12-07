package vn.finance.profile.business.domain.usecase

import kotlinx.coroutines.flow.Flow
import vn.core.domain.ResultModel
import vn.core.usecase.BaseUseCase
import vn.finance.profile.business.domain.model.PersonModel
import vn.finance.profile.business.domain.repository.GetProfileRepository
import javax.inject.Inject

class GetProfileUseCase @Inject constructor(private val repository: GetProfileRepository) :
    BaseUseCase<Unit, ResultModel<PersonModel>>() {
    override fun execute(vararg params: Unit?): Flow<ResultModel<PersonModel>> {
        return repository.getProfile()
    }
}