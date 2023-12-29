//package com.youcode.sunquizz.Level;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Arrays;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//@SpringBootTest
//public class LevelServiceTest {
//
//    @Mock
//    private LevelRepository levelRepository;
//
//    @InjectMocks
//    private LevelService levelService;
//
//    @Test
//    public void testGetLevel_WhenLevelExists_ShouldReturnLevel() {
//        Level expectedLevel = new Level();
//        expectedLevel.setId(1);
//        when(levelRepository.findById(1)).thenReturn(Optional.of(expectedLevel));
//
//        Level resultLevel = levelService.getLevel(1);
//
//        assertEquals(expectedLevel, resultLevel);
//    }
//
//    @Test
//    public void testGetLevel_WhenLevelDoesNotExist_ShouldReturnNull() {
//        when(levelRepository.findById(1)).thenReturn(Optional.empty());
//
//        Level resultLevel = levelService.getLevel(1);
//
//        assertNull(resultLevel);
//    }
//
//    @Test
//    public void testGetLevels_ShouldReturnListOfLevels() {
//        Level level1 = new Level();
//        Level level2 = new Level();
//        when(levelRepository.findAll()).thenReturn(Arrays.asList(level1, level2));
//
//        Iterable<Level> resultLevels = levelService.getLevels();
//
//        assertEquals(Arrays.asList(level1, level2), resultLevels);
//    }
//
//    @Test
//    public void testCreateLevel_ShouldReturnCreatedLevel() {
//        Level inputLevel = new Level();
//        when(levelRepository.save(inputLevel)).thenReturn(inputLevel);
//
//        Level createdLevel = levelService.createLevel(inputLevel);
//
//        assertEquals(inputLevel, createdLevel);
//    }
//
//    @Test
//    public void testUpdateLevel_WhenLevelExists_ShouldReturnUpdatedLevel() {
//        Level inputLevel = new Level();
//        inputLevel.setId(1);
//        Level existingLevel = new Level();
//        when(levelRepository.findById(1)).thenReturn(Optional.of(existingLevel));
//        when(levelRepository.save(inputLevel)).thenReturn(inputLevel);
//
//        Level updatedLevel = levelService.updateLevel(inputLevel, 1);
//
//        assertEquals(inputLevel, updatedLevel);
//    }
//
//    @Test
//    public void testUpdateLevel_WhenLevelDoesNotExist_ShouldReturnNull() {
//        Level inputLevel = new Level();
//        inputLevel.setId(1);
//        when(levelRepository.findById(1)).thenReturn(Optional.empty());
//
//        Level updatedLevel = levelService.updateLevel(inputLevel, 1);
//
//        assertNull(updatedLevel);
//    }
//
//    @Test
//    public void testDeleteLevel_WhenLevelExists_ShouldReturnTrue() {
//        Level existingLevel = new Level();
//        existingLevel.setId(1);
//        when(levelRepository.findById(1)).thenReturn(Optional.of(existingLevel));
//
//        boolean result = levelService.deleteLevel(1) == 1;
//
//        assertTrue(result);
//        verify(levelRepository, times(1)).delete(existingLevel);
//    }
//
//    @Test
//    public void testDeleteLevel_WhenLevelDoesNotExist_ShouldReturnFalse() {
//        when(levelRepository.findById(1)).thenReturn(Optional.empty());
//
//        boolean result = levelService.deleteLevel(1) == 1;
//
//        assertFalse(result);
//        verify(levelRepository, never()).delete(any());
//    }
//}
