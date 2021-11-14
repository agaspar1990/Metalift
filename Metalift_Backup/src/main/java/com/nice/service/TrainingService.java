package com.nice.service;

import com.nice.entity.Exercise;
import com.nice.entity.Training;
import com.nice.entity.TrainingBlock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface TrainingService {
    Page<Training> getTrainings(Pageable pageable);
    Training createTraining(Training training);
    void deleteTraining(UUID id);
    Training updateTraining(Training training);
    TrainingBlock addTrainingBlock(Training training, TrainingBlock trainingBlock);
    void removeTrainingBlock (UUID trainingId, UUID TrainingBlockId);
    TrainingBlock modifyTrainingBlock(Training training, TrainingBlock trainingBlock);
    Page<Training> getTrainingBlocksForTraining(Training training, Pageable pageable);

}
