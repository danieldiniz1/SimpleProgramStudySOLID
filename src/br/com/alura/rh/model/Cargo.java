package br.com.alura.rh.model;

public enum Cargo {

	ASSISTENTE (1, "este é o assistente, cargo mais básico") {
		@Override
		public Cargo getProximoCargo() {
			return ANALISTA;
		}
	},
	ANALISTA (2, "este é o analista, cargo médio") {
		@Override
		public Cargo getProximoCargo() {
			return ESPECIALISTA;
		}
	},
	ESPECIALISTA (3, "este é o especialista, cargo alto") {
		@Override
		public Cargo getProximoCargo() {
			return GERENTE;
		}
	},
	GERENTE (0, "este é o gerente, cargo mais alto no operacional") {
		@Override
		public Cargo getProximoCargo() {
			return GERENTE;
		}
	};

	private Integer cod;
	private String descricao;

	Cargo(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Cargo toEnum(Integer cod){
		if (cod.equals(null)){
			return null;
		}

		for (Cargo cargo : Cargo.values()) {
			if (cod.equals(cargo.getCod())){
				return cargo;
			}
		}
		throw new IllegalArgumentException("código do cargo inválido: " + cod);
	}

	public abstract Cargo getProximoCargo();

}
