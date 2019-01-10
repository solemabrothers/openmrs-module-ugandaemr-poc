<%
    // although called "patientDashboard" this is actually the patient visits screen, and clinicianfacing/patient is the main patient dashboard
    ui.decorateWith("appui", "standardEmrPage")
    ui.includeCss("coreapps", "org.openmrs.module.ugandaemrpoc.fragment.controller.patientsearch/patientSearchWidget.styles")
    ui.includeJavascript("uicommons", "bootstrap-collapse.js")
    ui.includeJavascript("uicommons", "bootstrap-transition.js")
    ui.includeCss("uicommons", "styleguide/index.styles")
    ui.includeCss("uicommons", "datatables/dataTables_jui.styles")

%>
<script type="text/javascript">
    <% if (breadcrumbs) { %>
    var breadcrumbs = ${ breadcrumbs };
    <% } else { %>
    var breadcrumbs = [
        { icon: "icon-home", link: '/' + OPENMRS_CONTEXT_PATH + '/index.htm' },
        { label: "${ ui.message(label)}"}
    ];
    <% } %>
    jq(function() {
        jq('#patient-search').focus();
    });
</script>

<h2>
    ${ ui.message(heading) }
</h2>
<script type="text/javascript">

</script>
<style>
.dashboard .que-container {
    display: inline;
    float: left;
    width: 65%;
    margin: 0 1.04167%;
}

.dashboard .alert-container {
    display: inline;
    float: left;
    width: 30%;
    margin: 0 1.04167%;
}

.dashboard .action-section ul {
    background: #63343c;
    color: white;
    padding: 7px;
}

#patient-search {
    min-width: 55%;
    color: #363463;
    display: block;
    padding: 5px 10px;
    margin: 0;
    margin-top: 5px;
    background-color: #FFF;
    border: 1px solid #dddddd;
}
</style>

<div class="dashboard clear">
    <div class="que-container column">
        <div class="info-section">
            <div class="info-header">
                <i class="icon-diagnosis"></i>

                <h3 style="width: 50%">PATIENTS IN QUEUE</h3> <span
                    style="right:auto;width: 40%;font-weight: bold"><input name="includeInSystem"
                                                                           type="checkbox"> Include Patients In System
            </span></h4>
            </div>
            <span>
                <form method="get" id="patient-search-form" onsubmit="return false">
                    <input type="text" id="patient-search"
                           placeholder="${ui.message("coreapps.findPatient.search.placeholder")}" autocomplete="off"
                           style="width: 10%;"/><i id="patient-search-clear-button" class="small icon-remove-sign"></i>
                </form>
            </span>

            <div class="info-body">
                <table>
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Names</th>
                        <th>Age (Years)</th>
                        <th>PREVIOUS LOCATION</th>
                        <th>PREVIOUS PROVIDER</th>
                        <th>ACTION</th>
                    </tr>
                    </thead>
                    <tbody>
                    <% if (patientQueueList != null) {
                        patientQueueList.each {
                    %>
                    <tr>
                        <td>${it.patient.id}</td>
                        <td>${it.patient.familyName} ${it.patient.givenName}</td>
                        <td>${it.patient.age}</td>
                        <td>${it.locationFrom.name}</td>
                        <td>${it.provider.name}</td>
                        <td>
                            <i class="icon-dashboard view-action" title="Goto Patient's Dashboard"
                               onclick="location.href = '${ui.pageLink("coreapps",'clinicianfacing/patient',[patientId: it.patient.patientId])}'"></i>
                            <i class="icon-exchange edit-action" title="Transfer To Another Provider"
                               onclick="location.href = '${ui.pageLink("ugandaemrpoc",'addPatientToQueue',[patientId: it.patient.patientId,])}'"></i>
                            <i class="icon-envelope view-action" title="Patient Note"
                               onclick="location.href = '${ui.pageLink("ugandaemrpoc",'addPatientToQueue',[patientId: it.patient.patientId])}'"><span
                                    style="color: red">1</span></i>
                        </td>
                    </tr>
                    <% }
                    } %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <div class="alert-container column">
        <div class="action-section">
            <h3 style="color: black; text-align: center;"><span style="color: red">${alerts.size()}</span> Messages</h3>
            <ul style="max-height: 200px; overflow: scroll;">
                <% alerts.each { %>
                <li><a href=""><i class="icon-comment"></i>${it.text.take(40)}</a></li>
                <% } %>
            </ul>
        </div>
    </div>
</div>
