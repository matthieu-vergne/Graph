package fr.vergne.graph.impl;

import java.util.Collection;
import java.util.Collections;

import fr.vergne.graph.Edge;
import fr.vergne.graph.Graph;

public class ImmutableGraph<CVertex, CEdge extends Edge<? extends CVertex>>
		extends ImmutableHypergraph<CVertex, CEdge> implements
		Graph<CVertex, CEdge> {

	public ImmutableGraph(Collection<? extends CVertex> vertices,
			Collection<? extends CEdge> edges) {
		super(vertices, edges);
	}

	public ImmutableGraph() {
		this(Collections.<CVertex> emptyList(), Collections.<CEdge> emptyList());
	}

}
