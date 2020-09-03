package appLaunchTwo.Logic;

import appLaunchTwo.Classes.Program;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HandlerProgramTest {
    HandlerProgram handlerProgram = new HandlerProgram();
List<Program> recordList = new ArrayList<>();
List<Program> expectedRecordList = new ArrayList<>();

    @Before
    @Test
    void setProgramList() {
//        handlerProgram.setProgramList(handlerProgram.getProgramList());
        Assert.assertNull(handlerProgram.getProgramList());
    }

    @Test
    void addProgram() {
    }

    @Test
    void findProgram() {
    }

    @Test
    void testFindProgram() {
    }

    @Test
    void getProgramList() {
        Program program1 = new Program(1,"TEST1","test2","TEST3");
        Program program2 = new Program(2,"test2","testst","TEST3");
        Program program3 = new Program(3,"TEST1","TEST1","TEST3");

        handlerProgram.addProgram(program1);
        handlerProgram.addProgram(program2);
        handlerProgram.addProgram(program3);

        recordList.add(program1);
        recordList.add(program2);
        recordList.add(program3);

        expectedRecordList = handlerProgram.getProgramList();

        Assert.assertEquals(expectedRecordList,recordList);

    }

    @Test
    void deleteProgram() {
    }

    @Test
    void updateProgram() {
    }

    @Test
    void copyProgram() {
    }

    @Test
    void searchFile() {
    }

    @Test
    void searchNameProgram() {
    }
}