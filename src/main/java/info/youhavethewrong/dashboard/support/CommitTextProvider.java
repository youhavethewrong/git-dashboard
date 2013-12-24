package info.youhavethewrong.dashboard.support;

import info.youhavethewrong.dashboard.resources.Commit;

import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.core.*;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.google.gson.*;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class CommitTextProvider extends JacksonJsonProvider {
	public CommitTextProvider() {
		super();
	}

	public CommitTextProvider(ObjectMapper mapper) {
		super(mapper);
	}

	private boolean isValidClass(Class<?> type) {
		return type.equals(Commit.class);
	}

	private boolean isValidGeneric(Type genericType) {
		return genericType != null
				&& genericType
						.toString()
						.equals("java.util.List<info.youhavethewrong.dashboard.resources.Commit>");
	}

	@Override
	public boolean isWriteable(Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		return isValidClass(type) || isValidGeneric(genericType);
	}

	@Override
	public void writeTo(Object value, Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders,
			OutputStream entityStream) throws IOException {
		Gson gson = new GsonBuilder().create();
		entityStream.write(gson.toJson(value).getBytes());
	}
}
