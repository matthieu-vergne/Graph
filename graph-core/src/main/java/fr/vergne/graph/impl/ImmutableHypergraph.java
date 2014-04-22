package fr.vergne.graph.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

import fr.vergne.graph.Hyperedge;
import fr.vergne.graph.Hypergraph;

public class ImmutableHypergraph<VertexType, EdgeType extends Hyperedge<? extends VertexType>>
		implements Hypergraph<VertexType, EdgeType> {

	private final Collection<VertexType> vertices;
	private final Collection<EdgeType> edges;

	public ImmutableHypergraph(Collection<? extends VertexType> vertices,
			Collection<? extends EdgeType> edges) {
		this.vertices = Collections
				.unmodifiableSet(new LinkedHashSet<VertexType>(vertices));
		this.edges = Collections.unmodifiableSet(new LinkedHashSet<EdgeType>(
				edges));
	}

	public Collection<VertexType> getVertices() {
		return vertices;
	}

	public Collection<EdgeType> getEdges() {
		return edges;
	}
}
