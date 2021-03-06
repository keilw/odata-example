/**
 * Copyright (c) 2015-2018 SDL Group and others
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sdl.odata.example.service;

import com.sdl.odata.api.ODataException;
import com.sdl.odata.api.edm.annotations.EdmFunction;
import com.sdl.odata.api.edm.annotations.EdmReturnType;
import com.sdl.odata.api.edm.model.Operation;
import com.sdl.odata.api.processor.datasource.factory.DataSourceFactory;
import com.sdl.odata.api.service.ODataRequestContext;
import com.sdl.odata.example.Material;
import com.sdl.odata.example.datasource.InMemoryDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentMap;

/**
 * @author keilw
 */
@EdmFunction(name = "GetAverageWeight", namespace = "SDL.OData.Example", isBound = true)
@EdmReturnType(type = "Edm.Double")
public class GetAverageWeight implements Operation<Double> {
    private static final Logger LOG = LoggerFactory.getLogger(GetAverageWeight.class);

    @Override
    public Double doOperation(ODataRequestContext oDataRequestContext, DataSourceFactory dataSourceFactory) throws ODataException {
        LOG.debug("Executing function 'GetAverageWeight'");

        InMemoryDataSource dataSource = (InMemoryDataSource) dataSourceFactory.getDataSource(oDataRequestContext, "SDL.OData.Example.Person");
        ConcurrentMap<String, Material> personConcurrentMap = dataSource.getPersonConcurrentMap();
        Double result = personConcurrentMap.values().stream().mapToDouble(Material::getWeight).average().getAsDouble();
        LOG.debug("Average age: {}", result);

        return result;
    }
}
