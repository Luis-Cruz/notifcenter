package pt.utl.ist.notifcenter.api.json;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.fenixedu.bennu.core.annotation.DefaultJsonAdapter;
import org.fenixedu.bennu.core.json.JsonAdapter;
import org.fenixedu.bennu.core.json.JsonBuilder;
import pt.utl.ist.notifcenter.domain.Remetente;
import pt.utl.ist.notifcenter.utils.ErrorsAndWarnings;
import pt.utl.ist.notifcenter.utils.NotifcenterException;

@DefaultJsonAdapter(Remetente.class)
public class RemetenteAdapter implements JsonAdapter<Remetente> {

    @Override
    public Remetente create(JsonElement jsonElement, JsonBuilder ctx) {
        /*
        final JsonObject jObj = jsonElement.getAsJsonObject();
        Aplicacao app = getRequiredValue(jObj, "app");
        String name = getRequiredValue(jObj, "name");
        return Remetente.createRemetente(app, name);
        */
        return null;
    }

    @Override
    public Remetente update(JsonElement jsonElement, Remetente remetente, JsonBuilder ctx) {
        final JsonObject jObj = jsonElement.getAsJsonObject();
        String nome = getRequiredValue(jObj, "name");
        return remetente.update(nome);
    }

    @Override
    public JsonElement view(Remetente obj, JsonBuilder ctx) {
        JsonObject jObj = new JsonObject();
        jObj.addProperty("name", obj.getNome());
        jObj.addProperty("id", obj.getExternalId());
        jObj.addProperty("appId", obj.getAplicacao().getExternalId());
        return jObj;
    }

    private String getRequiredValue(JsonObject obj, String property) {
        if (obj.has(property)) {
            return obj.get(property).getAsString();
        }
        throw new NotifcenterException(ErrorsAndWarnings.INVALID_ENTITY_ERROR, "Missing parameter " + property + "!");
    }

}
