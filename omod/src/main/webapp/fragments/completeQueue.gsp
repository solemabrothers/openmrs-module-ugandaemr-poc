<%
    ui.includeJavascript("ugandaemrpoc", "patientqueue.js")
%>

<script type="text/javascript">
    jq(document).ready(function () {
    });
</script>

<div id="complete_patient_queue" class="dialog" style="display: none">
    <div class="dialog-header">
        <i class="icon-remove-sign"></i>

        <h3>Complete Patient Encounter Session</h3>
    </div>

    <div>
        <p class="center" style="text-align: center;font-weight: bolder">
            Are you sure you want to complete Patient Session.
        </p>
    </div>

    <div class="dialog-content form">
        <button class="cancel" id="">NO</button>
        <button class="confirm right" id="submit">YES<i class="icon-spinner icon-spin icon-2x"
                                                        style="display: none; margin-left: 10px;"></i></button>
    </div>
</div>

