package com.game.backend.userdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class userDataService {
    private final userDataRepository userDatarepository;
    private final dataTableRepository dataTablerepository;
    @Autowired
    public userDataService(userDataRepository userDatarepository,dataTableRepository dataTablerepository){
        this.userDatarepository=userDatarepository;
        this.dataTablerepository = dataTablerepository;
    }
    public dataTable dataTableAdd(dataTable datatable){
        return dataTablerepository.save(datatable);
    }
    public List<userDataDTO> userDataList(int userCode){
        List<userDataDTO> userdataDtoList = new ArrayList<>();
        List<userData> userDataList = new ArrayList<>();
        userDataList=userDatarepository.findAllByUserUserCode(userCode);

        for(userData userdata:userDataList){
            userDataDTO userDataDto = new userDataDTO();
            userDataDto.setDataCode(userdata.getDatatable().getDataCode());
            userDataDto.setDataName(dataTablerepository.findDataNameByDataCode(userdata.getDatatable().getDataCode()));
            userDataDto.setDataValue(userdata.getDataValue());
            userdataDtoList.add(userDataDto);
        }

        return userdataDtoList;
    }
    public void userDataUpdate(dataDTO dataDto){
        List<dataObject> dataList = dataDto.getDataList();
        for(dataObject dataobject:dataList){
           int dataCode = dataTablerepository.findByDataName(dataobject.getDataName());
           userData userdata =new userData();
                 userdata=  userDatarepository.findByUserUserCodeAndDatatableDataCode(dataDto.getUserCode(),dataCode);
           userdata.setDataValue(dataobject.getDataValue());
            userDatarepository.save(userdata);
        }
    }
}
