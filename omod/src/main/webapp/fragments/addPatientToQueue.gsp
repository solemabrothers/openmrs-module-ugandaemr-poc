<%
    ui.includeJavascript("ugandaemrpoc", "patientqueue.js")
%>

<script type="text/javascript">
    jq(document).ready(function () {
    });
</script>

<div id="add_patient_to_queue_dialog" class="dialog" style="display: none">
    <div class="dialog-header">
        <i class="icon-remove-sign"></i>

        <h3>Add Patient To Queue</h3>
    </div>

    <div>
        <form method="post">
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


                    <span>

                    </span>
                <div class="dialog-content form">
                    <button class="cancel" id="">NO</button>
                    <input type="submit" class="confirm" value="${ui.message("ugandaemrpoc.send.label")}">
                </div>
            </fieldset>
        </form>
    </div>

</div>

