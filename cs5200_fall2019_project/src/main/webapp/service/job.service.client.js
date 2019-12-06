(function () {
    angular
        .module("cs5200_fall2019_project")
        .factory("jobService", jobService);
    function jobService($http) {
        var api = {
            "searchJobByKeywords": searchJobByKeywords,
            "searchJobById": searchJobById

        };
        return api;
        //key = e9d6324e7773666093c5dfa0b4212ff0
        function searchJobByKeywords(keywords) {
            var urlBase = "https://authenticjobs.com/api/?api_key=e9d6324e7773666093c5dfa0b4212ff0&method=aj.jobs.search&keywords=QUERY";
            var url = urlBase.replace("QUERY", keywords);
            return $http.get(url);
        }

        function searchJobById(id) {
            var urlBase = "https://authenticjobs.com/api/?api_key=e9d6324e7773666093c5dfa0b4212ff0&method=aj.jobs.get&id=ID";
            var url = urlBase.replace("ID", id);
            return $http.get(url);
        }
    }
})();

