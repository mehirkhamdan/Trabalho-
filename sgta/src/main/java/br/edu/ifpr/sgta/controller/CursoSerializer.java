package br.edu.ifpr.sgta.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import br.edu.ifpr.sgta.model.Curso;


public class CursoSerializer extends StdSerializer<Set<Curso>> {
	
	private static final long serialVersionUID = 1L;

	public CursoSerializer() {
		this(null);
	}

	public CursoSerializer(Class<Set<Curso>> t) {
		super(t);
	}

	@Override
	public void serialize(Set<Curso> curso, JsonGenerator generator, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		Map<String, Object> cursoMap = new HashMap<>();
		List<Map<String, Object>> cursoList = new ArrayList<>();
		for (Curso c : curso) {
			cursoMap = new HashMap<>();
			cursoMap.put("id", c.getId());
			cursoMap.put("descricao", c.getDescricao());
			cursoList.add(cursoMap);
		}
		generator.writeObject(cursoList);
	}

}


