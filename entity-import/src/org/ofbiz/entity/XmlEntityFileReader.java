/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.ofbiz.entity;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;

/**
 * Read entities from a XML file
 * @author Liang Zhang
 */
public class XmlEntityFileReader implements EntityFileReader {

	@Override
	public String getEntitiesInXml(File file) throws Exception {
		InputStream is = new FileInputStream(file);
		return this.getEntitiesInXml(is);
	}
	
	@Override
	public String getEntitiesInXml(ByteBuffer byteBuffer) throws Exception {
	    byte[] inputByteArray = byteBuffer.array();
	    InputStream is = new ByteArrayInputStream(inputByteArray);
		return this.getEntitiesInXml(is);
	}
	
	@Override
	public String getEntitiesInXml(InputStream is) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		
		StringBuffer buffer = new StringBuffer();
		while(reader.ready()) {
			buffer.append(reader.readLine());
		}
		return buffer.toString();
	}

}
