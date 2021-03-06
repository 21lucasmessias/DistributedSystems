package com.view.plantview.sensor.api.application.downtime.retrieve.list;

import com.view.plantview.sensor.api.application.UseCase;
import com.view.plantview.sensor.api.domain.downtime.DowntimeSearchQuery;
import com.view.plantview.sensor.api.domain.pagination.Pagination;

public abstract class ListDowntimeUseCase extends UseCase<DowntimeSearchQuery, Pagination<DowntimeListOutput>> {
}
