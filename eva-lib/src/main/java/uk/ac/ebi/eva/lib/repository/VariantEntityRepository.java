/*
 * European Variation Archive (EVA) - Open-access database of all types of genetic
 * variation data from all species
 *
 * Copyright 2016 EMBL - European Bioinformatics Institute
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.ac.ebi.eva.lib.repository;

import org.opencb.biodata.models.feature.Region;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import uk.ac.ebi.eva.commons.models.metadata.VariantEntity;

import java.util.List;

/**
 * Spring MongoRepository for VariantEntity class.
 *
 * Methods include querying by id, and by region.
 */
public interface VariantEntityRepository extends MongoRepository<VariantEntity, String>, VariantEntityRepositoryCustom {

    enum RelationalOperator { EQ, GT, LT, GTE, LTE, NONE }

    List<VariantEntity> findByIdsAndComplexFilters(String id, List<String> studies, List<String> consequenceType,
                                                   RelationalOperator mafOperator,
                                                   Double mafValue,
                                                   RelationalOperator polyphenScoreOperator,
                                                   Double polyphenScoreValue,
                                                   RelationalOperator siftScoreOperator,
                                                   Double siftScoreValue,
                                                   Pageable pageable);

    List<VariantEntity> findByRegionAndComplexFilters(String chromosome, int start, int end, List<String> studies,
                                                      List<String> consequenceType,
                                                      RelationalOperator mafOperator,
                                                      Double mafValue,
                                                      RelationalOperator polyphenScoreOperator,
                                                      Double polyphenScoreValue,
                                                      RelationalOperator siftScoreOperator,
                                                      Double siftScoreValue,
                                                      Pageable pageable);

    List<VariantEntity> findByRegionsAndComplexFilters(List<Region> regions, List<String> studies,
                                                       List<String> consequenceType,
                                                       RelationalOperator mafOperator,
                                                       Double mafValue,
                                                       RelationalOperator polyphenScoreOperator,
                                                       Double polyphenScoreValue,
                                                       RelationalOperator siftScoreOperator,
                                                       Double siftScoreValue,
                                                       Pageable pageable);
}