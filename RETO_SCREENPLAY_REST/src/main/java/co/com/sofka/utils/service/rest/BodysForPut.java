package co.com.sofka.utils.service.rest;

public enum BodysForPut {

    BODY_FOR_PUT_REQRES("{\n" +
            "    \"name\": \"morpheus\",\n" +
            "    \"job\": \"zion resident\"\n" +
            "}"),
    BODY_FOR_PUT_JSONPLACEHOLDER("{\n" +
            "  \"userId\": 1,\n" +
            "  \"id\": 1,\n" +
            "  \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\n" +
            "  \"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\n" +
            "}");

    private final String value;

    public String getValue() {
        return value;
    }

    BodysForPut(String value) {
        this.value = value;
    }
}
