package com.tamersarioglu.izmirlist.presentation.usecases

import com.tamersarioglu.izmirlist.data.bazaardata.BazaarData
import com.tamersarioglu.izmirlist.data.service.ServiceRepository
import com.tamersarioglu.izmirlist.presentation.Resource
import kotlinx.coroutines.flow.Flow

class GetBazaarLocationsUseCase(private val repository: ServiceRepository) {
    operator fun invoke(): Flow<Resource<List<BazaarData>>> {
        return repository.getNeighborhoodBazaarPlacesData()
    }
}