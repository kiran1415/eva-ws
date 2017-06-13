/*
 * Copyright 2017 EMBL - European Bioinformatics Institute
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.ac.ebi.eva.server.configuration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import uk.ac.ebi.eva.lib.configuration.DbCollectionsProperties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DbCollectionsPropertiesTest {

    @Autowired
    private DbCollectionsProperties dbCollectionsProperties;

    @Value("${db.collection-names.files}")
    private String expectedFiles;

    @Test
    public void testEvaPropertyAutowiring() {
        assertNotNull(dbCollectionsProperties);
        assertNotNull(dbCollectionsProperties.getVariants());
        assertEquals(expectedFiles, dbCollectionsProperties.getFiles());
    }

}
