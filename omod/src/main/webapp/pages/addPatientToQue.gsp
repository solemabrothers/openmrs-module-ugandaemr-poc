<%
    ui.includeJavascript("coreapps", "custom/addPatientToQue.js")
    ui.decorateWith("appui", "standardEmrPage", [title: ui.message("ugandaemrpoc.task.addPatientToQueue.label")])

    def htmlSafeId = { extension ->
        "${extension.id.replace(".", "-")}-${extension.id.replace(".", "-")}-extension"
    }

    Calendar cal = Calendar.getInstance()
    def maxAgeYear = cal.get(Calendar.YEAR)
    def minAgeYear = maxAgeYear - patient.getAge()
    def breadcrumbMiddle = breadcrumbOverride ?: '';
%>
<script type="text/javascript">
    var breadcrumbs = [
        {icon: "icon-home", link: '/' + OPENMRS_CONTEXT_PATH + '/index.htm'},
        {
            label: "${ ui.escapeJs(ui.message("ugandaemrpoc.task.addPatientToQueue.label")) }",
            link: '${ ui.urlBind("/" + contextPath + "coreapps/clinicianfacing/patient.page?patientId="+patientId, [ patientId: patient ] ) }'
        }
    ];


    jq(function () {
    });
</script>

${ui.includeFragment("coreapps", "patientHeader", [patient: patient])}
<h3>${ui.message("ugandaemrpoc.task.addPatientToQueue.label")}</h3>

<form method="post" id="mark-patient-dead">
    <fieldset style="min-width: 40%">

        <span id="deceased-container">

        </span>

        <p>
            <span id="cause-of-death-container">
                <label for="cause-of-death">
                    <span>${ui.message("ugandaemrpoc.location.label")}</span>
                </label>
                <select name="locationId" id="cause-of-death">
                    <option value="">${ui.message("ugandaemrpoc.location.selectTitle")}</option>
                    <% if (locationList != null) {
                        locationList.each { %>
                    <option value="${it.uuid}">${it.name}</option>
                    <%
                            }
                        }
                    %>
                </select>
                <span class="field-error" style="display: none;"></span>
                <% if (locationList == null) { %>
                <div><${ui.message("ugandaemrpoc.select.error")}</div>
                <% } %>
            </span>
        </p>

    </span>
        <p>
            <span id="cause-of-death-container">
                <label for="cause-of-death">
                    <span>${ui.message("ugandaemrpoc.provider.label")}</span>
                </label>
                <select name="providerId" id="cause-of-death">
                    <option value="">${ui.message("ugandaemrpoc.provider.selectTitle")}</option>
                    <% if (providerList != null) {
                        providerList.each {
                            if (it.getName() != null) {
                    %>

                    <option value="${it.providerId}">${it.getName()}</option>
                    <% }
                    }
                    }
                    %>
                </select>
                <span class="field-error" style="display: none;"></span>
                <% if (locationList == null) { %>
                <div><${ui.message("ugandaemrpoc.select.error")}</div>
                <% } %>
            </span>
        </p>

        <p>
            <span>
                <input type="submit" class="confirm" value="${ui.message("ugandaemrpoc.send.label")}">
            </span>
        </p>
    </fieldset>
</form>