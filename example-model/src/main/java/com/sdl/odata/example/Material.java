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
package com.sdl.odata.example;

import com.sdl.odata.api.edm.annotations.EdmEntity;
import com.sdl.odata.api.edm.annotations.EdmEntitySet;
import com.sdl.odata.api.edm.annotations.EdmProperty;

/**
 * @author rdevries
 * @author keilw
 */
@EdmEntity(namespace = "OData.Example", key = "material", containerName = "ZGW_MATERIAL_SERVICE_SRV")
@EdmEntitySet
public class Material {

    @EdmProperty(name = "material", nullable = false)
    private String personId;

    @EdmProperty(name = "IndSector", nullable = false)
    private String firstName;

    @EdmProperty(name = "Langu", nullable = false)
    private String lastName;
    
    @EdmProperty(name = "MatlDesc", nullable = false)
    private String description;

    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@EdmProperty(name = "age", nullable = false)
    private int age;

    public Material(String personId, String firstName, String lastName, String desc, int age) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = desc;
        this.age = age;
    }

    public Material() {
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
