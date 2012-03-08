/*******************************************************************************
 * Copyright (c) 2011-2012 Oracle. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 and Eclipse Distribution License v. 1.0 which accompanies
 * this distribution. The Eclipse Public License is available at
 * http://www.eclipse.org/legal/epl-v10.html and the Eclipse Distribution
 * License is available at http://www.eclipse.org/org/documents/edl-v10.php.
 * 
 * Contributors: dclarke - Bug 361016: Future Versions Examples
 ******************************************************************************/
package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ tests.internal.AllTests.class, 
                FullPersonWithEditions.class, 
                FuturePersonTests.class,
                DeleteTests.class,
                TemporalQueryRedirectorTests.class,
                ProxyWrapperUpdateTests.class,
                //ModifyCurrentTests.class})
                //DeleteContinuityTests.class,
                MultipleEditionQueries.class,
                DuplicateInsertOnCreateMerge.class,
                tests.editionsets.AllTests.class})
public class AllTests {
}
