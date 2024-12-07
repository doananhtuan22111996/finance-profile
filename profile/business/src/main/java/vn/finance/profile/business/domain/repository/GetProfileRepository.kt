package vn.finance.profile.business.domain.repository

import kotlinx.coroutines.flow.Flow
import vn.core.domain.ResultModel
import vn.finance.profile.business.domain.model.PersonModel

interface GetProfileRepository {
    fun getProfile(): Flow<ResultModel<PersonModel>>
}