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

import br.edu.ifpr.sgta.model.Turma;

	
	public class TurmaSerializer extends StdSerializer<Set<Turma>> {
		
		private static final long serialVersionUID = 1L;

		public TurmaSerializer() {
			this(null);
		}

		public TurmaSerializer(Class<Set<Turma>> t) {
			super(t);
		}

		@Override
		public void serialize(Set<Turma> turma, JsonGenerator generator, SerializerProvider provider)
				throws IOException, JsonProcessingException {
			Map<String, Object> turmaMap = new HashMap<>();
			List<Map<String, Object>> turmaList = new ArrayList<>();
			for (Turma t : turma) {
				turmaMap = new HashMap<>();
				turmaMap.put("id", t.getId());
				turmaMap.put("descricao", t.getDescricao());
				turmaList.add(turmaMap);
			}
			generator.writeObject(turmaList);
		}

	}



