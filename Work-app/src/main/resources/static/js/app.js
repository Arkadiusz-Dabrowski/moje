angular.module('app', ['ngResource']).controller('EmployeeController', function($resource) {
    var vm = this;
    var Employee = $resource('employee/:employeeid')
        vm.employee = new Employee();
        function refreshData(){
            vm.employees = Employee.query(
                function success(data,headers) {
                    console.log('Pobrane dane:' + data);
                    console.log(headers('Content-Type'));
                },
                function error(response){
                    console.log(response.status);
                });

        }
        vm.addEmployee =function (emlpoyee) {
            console.log(vm.employee._proto);
            vm.employee.save(function (data) {
                refreshData();
                vm.employee = new Employee();
            });
        }
        vm.loadData = function(id){
            vm.details = "Arek";
        }
        vm.appName = 'Employee Manager';
        refreshData();
        });


