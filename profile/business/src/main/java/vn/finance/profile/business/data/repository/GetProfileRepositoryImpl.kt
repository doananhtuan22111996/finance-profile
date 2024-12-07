package vn.finance.profile.business.data.repository

import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import vn.core.data.di.AnoRetrofitApiService
import vn.core.data.model.ObjectResponse
import vn.core.data.network.NetworkBoundService
import vn.core.domain.ResultModel
import vn.finance.profile.business.ProfileApiService
import vn.finance.profile.business.data.model.PersonRaw
import vn.finance.profile.business.domain.model.PersonModel
import vn.finance.profile.business.domain.repository.GetProfileRepository
import javax.inject.Inject

class GetProfileRepositoryImpl @Inject constructor(@AnoRetrofitApiService private val apiService: ProfileApiService) :
    GetProfileRepository {
    override fun getProfile(): Flow<ResultModel<PersonModel>> =
        object : NetworkBoundService<PersonRaw, PersonModel>() {
            override suspend fun onApi(): Response<ObjectResponse<PersonRaw>> {
                return apiService.getProfile()
            }

            override suspend fun processResponse(request: ObjectResponse<PersonRaw>?): ResultModel.Success<PersonModel> {
                return ResultModel.Success(data = request?.data?.raw2Model())
            }

        }.build()
}