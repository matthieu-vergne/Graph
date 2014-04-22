package fr.vergne.graph.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import fr.vergne.graph.GraphExplorer;
import fr.vergne.graph.Hyperedge;
import fr.vergne.graph.Hypergraph;

public class SimpleGraphExplorer<VertexType, EdgeType extends Hyperedge<? extends VertexType>, GraphType extends Hypergraph<VertexType, EdgeType>>
		implements GraphExplorer<VertexType, EdgeType, GraphType> {

	private final GraphType graph;

	public SimpleGraphExplorer(GraphType graph) {
		this.graph = graph;
	}

	@Override
	public GraphType getGraph() {
		return graph;
	}

	@Override
	public Iterator<VertexType> verticesIterator() {
		return graph.getVertices().iterator();
	}

	@Override
	public Iterator<EdgeType> edgesIterator() {
		return graph.getEdges().iterator();
	}

	@Override
	public Iterator<EdgeType> edgesIterator(VertexType vertex) {
		Collection<EdgeType> edges = new LinkedList<EdgeType>();
		for (EdgeType edge : graph.getEdges()) {
			if (edge.getVertices().contains(vertex)) {
				edges.add(edge);
			} else {
				continue;
			}
		}
		return edges.iterator();
	}

}
