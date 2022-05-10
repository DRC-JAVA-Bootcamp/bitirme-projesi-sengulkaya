package com.sengulkaya.app.service.rest.payrollmanagement.mapper;

import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Worker;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.WorkerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.WorkerResponseDTO;

import org.springframework.stereotype.Component;

@Component
public class WorkerMapper {
    public Worker toWorker(WorkerRequestDTO workerRequestDTO) {
        if ( workerRequestDTO == null ) {
            return null;
        }

        Worker worker = new Worker();

        //  private String citizenId;
        //    private String name;
        //    private LocalDate dateOfBirth;//Retirement benefits?
        //    private String jobTitle;
        //    private LocalDate dateOfEmployment;
        //    private LocalDate dateOfLeave;
        //    private double baseSalary;
        //    private double ratePerHour;
        //    private boolean active;
        //    private Long departmentId;

        worker.setCitizenId( workerRequestDTO.getCitizenId() );
        worker.setName( workerRequestDTO.getName() );
        worker.setDateOfBirth( workerRequestDTO.getDateOfBirth() );
        worker.setJobTitle( workerRequestDTO.getJobTitle() );
        worker.setDateOfEmployment( workerRequestDTO.getDateOfEmployment() );
        worker.setDateOfLeave( workerRequestDTO.getDateOfLeave() );
        worker.setBaseSalary( workerRequestDTO.getBaseSalary() );
        worker.setRatePerHour( workerRequestDTO.getRatePerHour() );
        worker.setActive( workerRequestDTO.isActive() );
        worker.setDepartmentId( workerRequestDTO.getDepartmentId() );

        return worker;
    }

    public WorkerResponseDTO toWorkerResponseDTO(Worker worker) {
        if ( worker == null ) {
            return null;
        }

        WorkerResponseDTO workerResponseDTO = new WorkerResponseDTO();
        //     private String citizenId;
        //    private String name;
        //    private LocalDate dateOfBirth;//Retirement benefits?
        //    private String departmentName;
        //    private String jobTitle;
        //    private LocalDate dateOfEmployment;
        //    private double baseSalary;
        //    private double ratePerHour;
        //    private boolean active;
        //    private Long departmentId;
        //    private Long employeeId;

        workerResponseDTO.setCitizenId( worker.getCitizenId() )
                .setName( worker.getName())
                .setDateOfBirth( worker.getDateOfBirth() )
                .setDepartmentName(worker.getDepartment().getDepartmentName())
                .setJobTitle( worker.getJobTitle())
                .setDateOfEmployment( worker.getDateOfEmployment() )
                .setBaseSalary( worker.getBaseSalary())
                .setRatePerHour( worker.getRatePerHour())
                .setActive( worker.isActive())
                .setDepartmentId( worker.getDepartment().getDepartmentId())
                .setEmployeeId( worker.getEmployeeId());


        return workerResponseDTO;
    }
}
