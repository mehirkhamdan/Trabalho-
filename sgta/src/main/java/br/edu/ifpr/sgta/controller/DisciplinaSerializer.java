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

import br.edu.ifpr.sgta.model.Disciplina;

public class DisciplinaSerializer extends StdSerializer<Set<Disciplina>> {
	
	private static final long serialVersionUID = 1L;

	public DisciplinaSerializer() {
		this(null);
	}

	public DisciplinaSerializer(Class<Set<Disciplina>> t) {
		super(t);
	}

	@Override
	public void serialize(Set<Disciplina> disciplina, JsonGenerator generator, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		Map<String, Object> disciplinaMap = new HashMap<>();
		List<Map<String, Object>> disciplinaList = new ArrayList<>();
		for (Disciplina c : disciplina) {
			disciplinaMap = new HashMap<>();
			disciplinaMap.put("id", c.getId());
			disciplinaMap.put("descricao", c.getDescricao());
			disciplinaList.add(disciplinaMap);
		}
		generator.writeObject(disciplinaList);
	}

}
