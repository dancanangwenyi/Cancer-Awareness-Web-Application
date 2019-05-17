//We tell Angular that maincancers is our main module, and 
//that the maincancers module depends on the ui.router module.
//A state is the basic building block for UI-Router applications. 
//This javascript object is a simple state definition

//the two states are registered using $stateProvider in a config block
//Because $stateProvider is an Angular Provider, you must inject it 
//into a .config() block using AngularJS Dependency Injection.
//configured a default url using urlRouterProvider
angular.module('myApp', ['ui.router']);
angular.module('myApp').config(['$stateProvider', '$urlRouterProvider',
    function ($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise("/home");
        $stateProvider
                .state('home', {
                    url: '/home',
                    views: {
                        "header": {templateUrl: 'partials/header.html'},
                        "mainContent": {templateUrl: 'partials/home.html', controller: 'homeController'},
                        "footer": {templateUrl: 'partials/footer.html'}
                    }
                })
                .state('carcinoma', {
                    url: '/carcinoma',
                    views: {
                        "header": {templateUrl: 'partials/header.html'},
                        "mainContent": {templateUrl: 'partials/carcinoma.html', controller: 'carcinomaController'},
                        "footer": {templateUrl: 'partials/footer.html'}
                    }

                })
                .state('leukemia', {
                    url: '/leukemia',
                    views: {
                        "header": {templateUrl: 'partials/header.html'},
                        "mainContent": {templateUrl: 'partials/leukemia.html', controller: 'leukemiaController'},
                        "footer": {templateUrl: 'partials/footer.html'}
                    }
                })
                .state('lymphoma', {
                    url: '/lymphoma',
                    views: {
                        "header": {templateUrl: 'partials/header.html'},
                        "mainContent": {templateUrl: 'partials/lymphoma.html', controller: 'lymphomaController'},
                        "footer": {templateUrl: 'partials/footer.html'}
                    }
                })
                .state('melanoma', {
                    url: '/melanoma',
                    views: {
                        "header": {templateUrl: 'partials/header.html'},
                        "mainContent": {templateUrl: 'partials/melanoma.html', controller: 'melanomaController'},
                        "footer": {templateUrl: 'partials/footer.html'}
                    }
                })
                .state('sarcoma', {
                    url: '/sarcoma',
                    views: {
                        "header": {templateUrl: 'partials/header.html'},
                        "mainContent": {templateUrl: 'partials/sarcoma.html', controller: 'sarcomaController'},
                        "footer": {templateUrl: 'partials/footer.html'}
                    }

                })
                .state('form', {
                    url: '/form',
                    views: {
                        "header": {templateUrl: 'partials/header.html'},
                        "mainContent": {templateUrl: 'partials/form.html', controller: 'formController'},
                        "footer": {templateUrl: 'partials/footer.html'}
                    }
                })
    }
]);

angular.module('myApp').controller('homeController', function ($scope,$http) {
    $scope.title = "What is cancer?";
    $scope.display = function () {
    $http.get('api/cancer').then(function(response){
        $scope.cancerData = response.data;
        //console.log("Yes "+$scope.cancerData);
    });
    };
    
    $scope.display();
    
    
});
angular.module('myApp').controller('carcinomaController', function ($scope, $http) {
    $scope.title = "Carcinoma Cancer";
    
    console.log("Title: " + $scope.title);
    
});
angular.module('myApp').controller('leukemiaController', function ($scope) {
    $scope.title = "Leukemia Cancer";
});
angular.module('myApp').controller('lymphomaController', function ($scope) {
    $scope.title = "Lymphoma Cancer";
});
angular.module('myApp').controller('melanomaController', function ($scope) {
    $scope.title = "Melanoma Cancer";
});
angular.module('myApp').controller('sarcomaController', function ($scope) {
    $scope.title = "Sarcoma Cancer";
});
angular.module('myApp').controller('formController',function ($scope, $http) {
    $scope.title = "Add cancer data into the database";
    $scope.submit = function () {
    var data = {
            cancerName: $scope.CancerName,
            lethalDegree: $scope.LethalDegree,
            treatmentType:$scope.TreatmentType
            
        };
        
        var final_data = [];
        
        final_data.push(data);
        
        console.log("Data: " + data.cancerName);
    $http.post('api/cancer',final_data).then(function(){
        $scope.message = "Successful inserted";
    },function(){ $scope.message = "failed";
    });
//    $scope.CancerName="";
//    $scope.LethalDegree="";
//    $scope.TreatmentType="";  
    };
    
    //$scope.submit();
    
});