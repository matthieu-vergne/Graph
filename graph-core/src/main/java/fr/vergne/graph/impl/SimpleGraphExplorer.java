package fr.vergne.graph.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import fr.vergne.graph.GraphExplorer;
import fr.vergne.graph.Hyperedge;
import fr.vergne.graph.Hypergraph;

public class SimpleGraphExplorer<CVertex, CHyperedge extends Hyperedge<? extends CVertex>, CHyperGraph extends Hypergraph<CVertex, CHyperedge>>
		implements GraphExplorer<CVertex, CHyperedge, CHyperGraph> {

	private final CHyperGraph graph;

	public SimpleGraphExplorer(CHyperGraph graph) {
		this.graph = graph;
	}

	@Override
	public CHyperGraph getGraph() {
		return graph;
	}

	@Override
	public Iterator<CVertex> verticesIterator() {
		return graph.getVertices().iterator();
	}

	@Override
	public Iterator<CHyperedge> edgesIterator() {
		return graph.getEdges().iterator();
	}

	@Override
	public Iterator<CHyperedge> edgesIterator(CVertex vertex) {
		Collection<CHyperedge> edges = new LinkedList<CHyperedge>();
		for (CHyperedge edge : graph.getEdges()) {
			if (edge.getVertices().contains(vertex)) {
				edges.add(edge);
			} else {
				continue;
			}
		}
		return edges.iterator();
	}

}
