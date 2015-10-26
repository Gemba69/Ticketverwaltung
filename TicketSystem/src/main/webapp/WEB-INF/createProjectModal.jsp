
<!-- NewProjectModal -->
<div id="newProject" class="modal modal-fixed-footer">
    <form action="CreateProject" method="post">
        <div class="modal-content">
            <h4>Neues Projekt erstellen</h4>
            <div class="row">

                <div class="input-field col s6">
                    <input name="projectCode" id="projectCode" type="text">
                    <label for="projectCode">Projektkürzel</label>
                </div>
                <div class="input-field col s6">
                    <input name="projectName" id="projectName" type="text" >
                    <label for="projectName">Projektname</label>
                </div>
                <div class="input-field col s12">
                    <textarea name="projectDesc" id="description" type="text" class="materialize-textarea"></textarea>
                    <label for="projectDesc">Beschreibung</label>
                </div>
            </div>
        </div>
        <div class="modal-footer">
            <a href="#!" class=" modal-action modal-close waves-effect waves-red btn-flat">Abbrechen</a>
            <button type="submit" class=" modal-action modal-close waves-effect waves-green btn-flat">Speichern</button>
        </div>
    </form>
</div>