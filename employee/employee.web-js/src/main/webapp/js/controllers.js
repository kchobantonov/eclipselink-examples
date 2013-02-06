/*******************************************************************************
 * Copyright (c) 2010-2013 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0 
 * which accompanies this distribution. 
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at 
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *  shsmith - EclipseLink 2.4
 ******************************************************************************/

'use strict';

/* Controllers */

function EmployeeListCtrl($scope, Employees) {
	$scope.employees = Employees.query();
}

function EmployeeEditCtrl($scope, $routeParams, $location, Employee) {
	$scope.employee = Employee.get({
		id : $routeParams.id
	});

	$scope.save = function() {
		$scope.employee.$save();
		$scope.cancel();
	};

	$scope.cancel = function() {
		$location.path("/home");
	};

}

function EmployeeCreateCtrl($scope, $location, Employee) {
	$scope.employee = new Employee();
	$scope.employee.gender = 'Male';
	
	$scope.save = function() {
		$scope.employee.$save();
		$scope.cancel();
	};

	$scope.cancel = function() {
		$location.path("/home");
	};
}