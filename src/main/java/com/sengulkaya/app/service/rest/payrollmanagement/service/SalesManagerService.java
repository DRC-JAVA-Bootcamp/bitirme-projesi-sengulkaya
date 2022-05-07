package com.sengulkaya.app.service.rest.payrollmanagement.service;

import com.sengulkaya.app.service.rest.payrollmanagement.data.dal.ServiceDAL;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.ManagerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.SalesManagerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.ManagerResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.SalesManagerResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.mapper.IManagerMapper;
import com.sengulkaya.app.service.rest.payrollmanagement.mapper.ISalesManagerMapper;

import java.util.List;

public class SalesManagerService  {
    private final ServiceDAL serviceDAL;
    private final ISalesManagerMapper salesManagerMapper;


    public SalesManagerService(ServiceDAL serviceDAL, ISalesManagerMapper salesManagerMapper) {

        this.serviceDAL = serviceDAL;
        this.salesManagerMapper = salesManagerMapper;
    }

    public SalesManagerResponseDTO saveSalesManager(SalesManagerRequestDTO salesManagerRequestDTO)
    {
        return salesManagerMapper.toSalesManagerResponseDTO
                (serviceDAL.saveSalesManager(salesManagerMapper.toSalesManager(salesManagerRequestDTO)));

    }

    public SalesManagerResponseDTO updateSalesManager(SalesManagerRequestDTO salesManagerRequestDTO)
    {
        //
    }

    public SalesManagerResponseDTO removeSalesManagerById(Long salesManagerId)
    {
//
    }

    public List<SalesManagerResponseDTO> findAllSalesManagers()
    {
        //

    }

}
