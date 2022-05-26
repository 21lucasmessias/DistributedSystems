package com.view.plantview.sensor.api.domain;

import com.view.plantview.sensor.api.domain.equipment.Equipment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EquipmentTest {

    @Test
    public void givenAValidParams_whenCallNewEquipment_thenInstantiateAEquipment() {
        final var expectedIdExternal = "1";
        final var expectedIdCompany = "1";
        final var expectedIdBranch = "1";

        final var actualEquipment = new Equipment(expectedIdExternal, expectedIdCompany, expectedIdBranch);

        Assertions.assertNotNull(actualEquipment);
        Assertions.assertEquals(expectedIdExternal, actualEquipment.getIdExternal());
        Assertions.assertEquals(expectedIdCompany, actualEquipment.getIdExternalCompany());
        Assertions.assertEquals(expectedIdBranch, actualEquipment.getIdExternalBranch());
    }
}
