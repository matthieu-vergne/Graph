package fr.vergne.graph.impl;

import fr.vergne.graph.Arc;

public class ImmutableArc<VertexType> extends ImmutableEdge<VertexType>
		implements Arc<VertexType> {

	public ImmutableArc(VertexType start, VertexType stop) {
		super(start, stop);
	}

	public VertexType getStart() {
		return getVertex1();
	}

	public VertexType getStop() {
		return getVertex2();
	}

	@Override
	public String toString() {
		return getStart() + "->" + getStop();
	}
}
