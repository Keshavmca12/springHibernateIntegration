var empApp=angular.module("empApp",[]);

empApp.controller("empCtrl",function($scope,$http){
	$scope.emp={};
	$scope.submitDetails=function(emp){
		$http({
			url:'/SpringHibernateIntegration/submitEmp', 
			method: "POST",
			params: {employee: emp}
		}).then(function(response){
			console.log("reponse"+response);
		});;
	};
	
});