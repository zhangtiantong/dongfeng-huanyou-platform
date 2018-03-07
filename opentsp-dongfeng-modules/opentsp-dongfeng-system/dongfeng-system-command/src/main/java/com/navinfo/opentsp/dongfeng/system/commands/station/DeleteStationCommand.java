package com.navinfo.opentsp.dongfeng.system.commands.station;

import com.navinfo.opentsp.dongfeng.common.command.BaseCommand;
import com.navinfo.opentsp.dongfeng.common.result.HttpCommandResultWithData;
import com.navinfo.opentsp.dongfeng.common.validation.group.GroupCommand;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @author tushenghong
 * @version 1.0
 * @date 2017-03-23
 * @modify
 * @copyright Navi Tsp
 */
public class DeleteStationCommand extends BaseCommand<HttpCommandResultWithData> {
    @NotNull(message = "stationId 不能为空", groups = {GroupCommand.class})
    @NotBlank(message = "stationId 不能为空", groups = {GroupCommand.class})
    private String stationId;
    @NotNull(message = "stationName 不能为空", groups = {GroupCommand.class})
    @NotBlank(message = "stationName 不能为空", groups = {GroupCommand.class})
    private String stationName;

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    @Override
    public Class<? extends HttpCommandResultWithData> getResultType() {
        return HttpCommandResultWithData.class;
    }
}