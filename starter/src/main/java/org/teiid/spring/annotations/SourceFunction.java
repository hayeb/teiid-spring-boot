/*
 * Copyright 2012-2014 the original author or authors.
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
package org.teiid.spring.annotations;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.teiid.query.function.TeiidFunction;

/**
 * Using this annotation define Data Source specific Function.<br/>
 * Using this annotation, you can define a static method on a class that is
 * annotated with &#64;UserDefinedFunctions, at runtime this method will be
 * available for execution in Teiid queries such as {@link SelectQuery}. During
 * runtime the function will be evaluated in the source database as it gets
 * pushed down to source for execution<br/> <br/>
 * 
 * For an example see {@link UserDefinedFunctions}.
 *
 * For more information checkout <a href=
 * "https://teiid.gitbooks.io/documents/content/dev/Source_Supported_Functions.html">Source
 * Supported Functions</a> in Teiid.
 * 
 * @See {@link TeiidFunction}
 */
@Target(ElementType.METHOD)
@Retention(RUNTIME)
public @interface SourceFunction {
	/**
	 * Defines the datasource name where the function needs to be defined.
	 * @return
	 */
	String source();
	/**
	 * Adds teiid_rel:native-query to the function; when omitted the function name executed as is
	 * @return  
	 */
	String nativequery() default "";
}
