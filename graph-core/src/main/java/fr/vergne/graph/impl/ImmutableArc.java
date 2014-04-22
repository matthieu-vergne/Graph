package fr.vergne.graph.impl;

import fr.vergne.graph.Arc;

public class ImmutableArc<CVertex> extends ImmutableEdge<CVertex> implements
		Arc<CVertex> {

	public ImmutableArc(CVertex start, CVertex stop) {
		super(start, stop);
	}

	public CVertex getStart() {
		return getVertex1();
	}

	public CVertex getStop() {
		return getVertex2();
	}

	@Override
	public String toString() {
		return getStart() + "->" + getStop();
	}
}
