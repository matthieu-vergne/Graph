package fr.vergne.graph.impl;

import java.util.Collection;
import java.util.Collections;

import fr.vergne.graph.Edge;
import fr.vergne.graph.Graph;

public class ImmutableGraph<VertexType, EdgeType extends Edge<? extends VertexType>>
		extends ImmutableHypergraph<VertexType, EdgeType> implements
		Graph<VertexType, EdgeType> {

	public ImmutableGraph(Collection<? extends VertexType> vertices,
			Collection<? extends EdgeType> edges) {
		super(vertices, edges);
	}

	public ImmutableGraph() {
		this(Collections.<VertexType> emptyList(), Collections
				.<EdgeType> emptyList());
	}

}
