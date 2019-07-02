<%
    config.require("afterSelectedUrl")
    def breadcrumbOverride = config.breadcrumbOverride ?: ""
    ui.includeCss("uicommons", "datatables/dataTables_jui.css")
    ui.includeCss("ugandaemrpoc", "patientsearch/patientSearchWidget.css")
    ui.includeJavascript("uicommons", "datatables/jquery.dataTables.min.js")
    ui.includeJavascript("ugandaemrpoc", "patientsearch/patientSearchWidget.js")
    ui.includeJavascript("uicommons", "moment-with-locales.min.js")
    ui.includeJavascript("ugandaemrpoc", "patientsearch/sockjs-0.3.4.js")
    ui.includeJavascript("ugandaemrpoc", "patientsearch/stomp.js")
%>
<style type="text/css">
img {
    width: 100px;
    height: auto;
}
</style>
<script type="text/javascript">
    var lastViewedPatients = [];
    <%  if (showLastViewedPatients && !doInitialSearch) {
            lastViewedPatients.each { it -> %>
    lastViewedPatients.push({
        uuid: "${ it.uuid }",
        name: "${ it.personName ? ui.escapeJs(ui.format(it.personName)) : '' }",
        gender: "${ it.gender }",
        age: "${ it.age ?: '' }",
        birthdate: "${ it.birthdate ? dateFormatter.format(it.birthdate) : '' }",
        birthdateEstimated: ${ it.birthdateEstimated },
        identifier: "${ it.patientIdentifier ? ui.escapeJs(it.patientIdentifier.identifier) : '' }"
    });
    <%      }
        }%>
    function handlePatientRowSelection() {
        this.handle = function (row) {
            var uuid = row.uuid;
            location.href = '/' + OPENMRS_CONTEXT_PATH + emr.applyContextModel('${ ui.escapeJs(config.afterSelectedUrl) }', {
                        patientId: uuid,
                        breadcrumbOverride: '${ ui.escapeJs(breadcrumbOverride) }'
                    });
        }
    }
    var handlePatientRowSelection = new handlePatientRowSelection();
    jq(function () {
        var widgetConfig = {
            initialPatients: lastViewedPatients,
            doInitialSearch: ${ doInitialSearch ? "\"" + ui.escapeJs(doInitialSearch) + "\"" : "null" },
            minSearchCharacters: ${ config.minSearchCharacters ?: 3 },
            afterSelectedUrl: '${ ui.escapeJs(config.afterSelectedUrl) }',
            breadcrumbOverride: '${ ui.escapeJs(breadcrumbOverride) }',
            searchDelayShort: ${ searchDelayShort },
            searchDelayLong: ${ searchDelayLong },
            handleRowSelection: ${ config.rowSelectionHandler ?: "handlePatientRowSelection" },
            dateFormat: '${ dateFormatJS }',
            locale: '${ locale }',
            defaultLocale: '${ defaultLocale }',
            messages: {
                info: '${ ui.message("coreapps.search.info") }',
                first: '${ ui.message("coreapps.search.first") }',
                previous: '${ ui.message("coreapps.search.previous") }',
                next: '${ ui.message("coreapps.search.next") }',
                last: '${ ui.message("coreapps.search.last") }',
                noMatchesFound: 'No matching Patient found in this hospital. Click to start remote search',
                noData: 'Patient file not found in this hospital. Click to start remote search',
                recent: '${ ui.message("coreapps.search.label.recent") }',
                searchError: '${ ui.message("coreapps.search.error") }',
                identifierColHeader: '${ ui.message("coreapps.search.identifier") }',
                nameColHeader: '${ ui.message("coreapps.search.name") }',
                genderColHeader: '${ ui.message("coreapps.gender") }',
                ageColHeader: '${ ui.message("coreapps.age") }',
                birthdateColHeader: '${ ui.message("coreapps.birthdate") }'
            }
        };
        new PatientSearchWidget(widgetConfig);
    });
</script>
<script type="text/javascript">
    var myVar;

    function myFunction() {
        document.getElementById("loader").className = "load";
        myVar = setTimeout(showPage, 5000);
    }
    function showPage() {
        document.getElementById("loader").style.display = "none";
        document.getElementById("myDiv").style.display = "block";
    }
</script>

<form method="get" id="patient-search-form" onsubmit="return false">
    <input type="text" id="patient-search" placeholder="${ui.message("coreapps.findPatient.search.placeholder")}"
           autocomplete="off" <% if (doInitialSearch) { %>value="${doInitialSearch}" <% } %>/>
</form>

<div id="patient-search-results"></div>