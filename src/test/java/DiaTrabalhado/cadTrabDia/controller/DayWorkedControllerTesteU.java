package DiaTrabalhado.cadTrabDia.controller;

import DiaTrabalhado.cadTrabDia.dto.CreateDayWorkRequest;
import DiaTrabalhado.cadTrabDia.service.IDayWorkService;
import DiaTrabalhado.cadTrabDia.service.impl.DayWorkService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;

@ExtendWith(MockitoExtension.class)
public class DayWorkedControllerTesteU {

    @Mock
    private DayWorkService DayWorkService;
    @InjectMocks
    private DayWorkedController dayWorkedController;

    @Test
    @DisplayName("Create Workday Test")
    void createDayWork_shouldReturn_success_WhenReceiveCreateWorkDay(){
        // Arrange - create the necessary test DayWork.
        var createDayWorkRequest = new CreateDayWorkRequest(
                "CMP Tile",
                "06/16/2026",
                "Arabian, Hidden Lakes and Floresta",
                180.00
        );

        // Act - execute the method under test.
        doNothing()
                .when(DayWorkService)
                .createDayWork(createDayWorkRequest);
        var response = dayWorkedController.createDayWork(createDayWorkRequest);

        // Assert - verify the expected result.
        var expected = "Day work successfully registerd.";
        assertEquals(expected, response);
    }

    @Test
    @DisplayName("CreateDayWorkWihtContractorNameResultsError")
    void createDayWork_shouldReturn_Error_WhenReceiveCreateWorkDayWithOut_ContractorName(){
        // Arrange - create the necessary test Costumer Name.
        var createDayWorkRequest = new CreateDayWorkRequest();
        createDayWorkRequest.setContractorName("CMP Tile");

        // Act - execute the method under test.
        var response = dayWorkedController.createDayWork(new CreateDayWorkRequest());

        // Assert - verify the expected result.
        var expected = "The Contractor Name field is required!";
        assertEquals(expected, response);
    }

    @Test
    @DisplayName("CreateDayWorkWihtDateResultsError")
    void createDayWork_shouldReturn_Error_WhenReceiveCreateWorkDayWithOut_Date(){
        // Arrange - create the necessary test data.
        var createDayWorkRequest = new CreateDayWorkRequest();
        createDayWorkRequest.setDate("06/16/2026");

        // Act - execute the method under test.
        var response = dayWorkedController.createDayWork(new CreateDayWorkRequest());

        // Assert - verify the expected result.
        var expected = "The Date field is required!";
        assertEquals(expected, response);
    }

    @Test
    @DisplayName("CreateDayWorkWihtDescriptionResultsError")
    void createDayWork_shouldReturn_Error_WhenReceiveCreateWorkDayWithOut_Description(){
        // Arrange - create the necessary test description.
        var createDayWorkRequest = new CreateDayWorkRequest();
        createDayWorkRequest.setDate("Arabian, Hidden Lakes and Floresta");

        // Act - execute the method under test.
        var response = dayWorkedController.createDayWork(new CreateDayWorkRequest());

        // Assert - verify the expected result.
        var expected = "The Description field is required!";
        assertEquals(expected, response);
    }

    @Test
    @DisplayName("CreateDayWorkWihtAmountDueResultsError")
    void createDayWork_shouldReturn_Error_WhenReceiveCreateWorkDayWithOut_AmountDue(){
        // Arrange - create the necessary test description.
        var createDayWorkRequest = new CreateDayWorkRequest();
        createDayWorkRequest.setAmountDue(180.00);

        // Act - execute the method under test.
        var response = dayWorkedController.createDayWork(new CreateDayWorkRequest());

        // Assert - verify the expected result.
        var expected = "Day Work sucessefuly registered";
        assertEquals(expected, response);
    }


}

